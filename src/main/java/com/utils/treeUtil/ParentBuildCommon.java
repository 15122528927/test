package com.utils.treeUtil;





import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 筛选树节点数据
 *
 * @author nijianchun
 * @since 2016年11月9日 下午4:16:11
 */
public class ParentBuildCommon {


    /**
     * 筛选节点 数据
     *
     * @param nodes
     * @param datas
     * @param className
     * @param idName
     * @param pidName
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> screenNodes(List<T> nodes, List<T> datas, String className, String idName, String pidName)
            throws Exception {
        List<T> tree = new ArrayList<>();// 树
        List<T> datas_middle = new ArrayList<>();// 中间

        for (T node : nodes) {// 遍历
            tree.add(node);
            buildNodes(node, tree, datas, datas_middle, className, idName, pidName);

        }

        //数据去重
        Set<T> sets = new HashSet<>();// 树
        List<T> tree_new = new ArrayList<>();// 树
        for(T node : tree){

            int number = 0;
            for(T set : sets){
                //判断 id是否 相等
                if (idEqual(node, set, className, idName, pidName)) {
                    number = 1;
                }
            }

            if(number == 0){
                tree_new.add(node);
                sets.add(node);
            }
        }
        return tree_new;
    }


    /**
     * 构建 树节点
     *
     * @param node
     * @param setNodes
     * @param listNodes
     * @param listNodesNew
     * @param className
     * @param idName
     * @param pidName
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> void buildNodes(T node, List<T> setNodes, List<T> listNodes, List<T> listNodesNew, String className,
                                      String idName, String pidName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        T nodeNew = null;
        for (T n : listNodes) {

            int number = 0;
            for (T n_subset : listNodesNew) {
                if (idEqual(n, n_subset, className, idName, pidName)) {
                    number = 1;
                }
            }

            if (number == 0) {
                if (isParent(node, n, className, idName, pidName)) {
                    listNodesNew.add(n);
                    setNodes.add(n);
                    nodeNew = n;
                    break; // 跳出循环
                }
            }
        }

        if (nodeNew != null) {
            buildNodes(nodeNew, setNodes, listNodes, listNodesNew, className, idName, pidName);
        } else {
            return;
        }
    }

    /**
     * 判断 id是否相等
     *
     * @param n
     * @param node
     * @param className
     * @param idName
     * @param pidName
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private static <T> boolean idEqual(T n, T node, String className,
                                       String idName, String pidName)
            throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {// node是n的父节点
        Class c = Class.forName(className);
        Method getId = c.getMethod("get" + upFirst(idName));// 获取id的get方法
        Method getPid = c.getMethod("get" + upFirst(idName));// 获取pid的get方法
        Object node_id = getId.invoke(node);// 调用id的get方法获取node的id值
        Object n_pid = getPid.invoke(n);// 调用pid的get方法获取n的pid值
        // 根据值的类型比较是否相同
        // TODO 先不处理类型的问题，直接用简单类型、封装类型、String判断
        if (n_pid != null && n_pid.toString().equals(node_id.toString())) {
            return true;
        }
        return false;
    }


    /**
     * 判断 是否为父子级关系
     *
     * @param n
     * @param node
     * @param className
     * @param idName
     * @param pidName
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private static <T> boolean isParent(T n, T node, String className,
                                        String idName, String pidName)
            throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {// node是n的父节点
        Class c = Class.forName(className);
        Method getId = c.getMethod("get" + upFirst(idName));// 获取id的get方法
        Method getPid = c.getMethod("get" + upFirst(pidName));// 获取pid的get方法
        Object node_id = getId.invoke(node);// 调用id的get方法获取node的id值
        Object n_pid = getPid.invoke(n);// 调用pid的get方法获取n的pid值
        // 根据值的类型比较是否相同
        // TODO 先不处理类型的问题，直接用简单类型、封装类型、String判断
        if (n_pid != null && n_pid.toString().equals(node_id.toString())) {
            return true;
        }
        return false;
    }


    /**
     * 字母首写大写
     *
     * @param name
     * @return
     */
    private static String upFirst(String name) {// 首字母大写
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}
