package geektime.spring.data.mybatisdemo;

import java.lang.reflect.Field;
import java.util.List;

public class Test {


    public static Boolean compareTwoClass(Object class1, Object class2, List<Field> ignoreFieldList) throws ClassNotFoundException, IllegalAccessException {
        //动态的获取指定对象的class
        Class<?> clazz1 = class1.getClass();
        Class<?> clazz2 = class2.getClass();
        // 获取类中所有的属性(public、protected、default、private)，但不包括继承的属性，返回 Field 对象的一个数组
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
        //遍历属性列表field1
        for (int i = 0; i < field1.length; i++) {
            //遍历属性列表field2
            for (int j = 0; j < field2.length; j++) {
                //如果field1[i]属性名与field2[j]属性名内容相同
                if (field1[i].getName().equals(field2[j].getName())) {
                    Boolean checkIgnoreField = true;
                    if (ignoreFieldList.size() > 0) {
                        for (int ignoreFieldNum = 0; ignoreFieldNum < ignoreFieldList.size(); ignoreFieldNum++) {
                            //如果要忽略的类型里存在，就跳过这个方法
                            if (field1[i].getName().equals(ignoreFieldList.get(ignoreFieldNum))) {
                                checkIgnoreField = false;
                            }
                        }
                        if (checkIgnoreField) {
                            //调过本次循环的下面语句执行
                            continue;
                        }
                        if (!compareTwo(field1[i], field2[j], class1, class2)) {
                            return false;
                        }
                        break;
                    } else {
                        if (!compareTwo(field1[i], field2[j], class1, class2)) {
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 对比两个数据是否内容相同
     *
     * @param
     * @return boolean类型
     */
    public static boolean compareTwo(Field field1, Field field2, Object class1, Object class2) throws IllegalAccessException {
        //让我们可以访问私有变量的值
        field1.setAccessible(true);
        field2.setAccessible(true);
        //如果field1[i]属性值与field2[j]属性值内容不相同
        //为了不重写equals方法目前只能比较基础的类型
        if ("java".equals(field1.getGenericType().toString())) {
        }
        //返回该类下面对应的该属性值，并返回结果
        Object object1 = field1.get(class1);
        Object object2 = field2.get(class2);
        if (object1 == null && object2 == null) {
            return true;
        }
        if (object1 == null) {
            return false;
        }
        if (object1.equals(object2)) {
            return true;
        }
        return false;
    }

}
