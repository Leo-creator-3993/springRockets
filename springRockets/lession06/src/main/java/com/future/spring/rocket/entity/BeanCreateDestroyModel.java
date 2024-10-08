package com.future.spring.rocket.entity;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class BeanCreateDestroyModel implements DisposableBean{

    public BeanCreateDestroyModel() {
        constructPrint(this.getClass());
    }

    @Override
    public void destroy() throws Exception {
        destroyPrint(this.getClass());
    }


    public static class CDModel1 implements DisposableBean {
        public CDModel1() {
            constructPrint(this.getClass());
        }

        @Override
        public void destroy() throws Exception {
            destroyPrint(this.getClass());
        }
    }

    public static class CDModel2 implements DisposableBean {

        private CDModel1 cdModel1;
        public CDModel2(CDModel1 cdModel1) {
            this.cdModel1 = cdModel1;
            constructPrint(this.getClass());
        }

        @Override
        public void destroy() throws Exception {
            destroyPrint(this.getClass());
        }
    }

    public static class CDModel3 implements DisposableBean {

        private CDModel2 cdModel2;
        public CDModel3(CDModel2 cdModel2) {
            this.cdModel2 = cdModel2;
            constructPrint(this.getClass());
        }

        @Override
        public void destroy() throws Exception {
            destroyPrint(this.getClass());
        }
    }

    public static class CDModel4 implements DisposableBean {
        public CDModel4() {
            constructPrint(this.getClass());
        }

        @Override
        public void destroy() throws Exception {
            destroyPrint(this.getClass());
        }
    }

    public static class CDModel5 implements DisposableBean {

        public CDModel5() {
            constructPrint(this.getClass());
        }

        @Override
        public void destroy() throws Exception {
            destroyPrint(this.getClass());
        }
    }

    public static class CDModel6 implements DisposableBean {

        public CDModel6() {
            constructPrint(this.getClass());
        }

        @Override
        public void destroy() throws Exception {
            destroyPrint(this.getClass());
        }
    }

    private CDModel1 cdModel1;
    public CDModel1 getCdModel1() {
        return cdModel1;
    }

    public void setCdModel1(CDModel1 cdModel1) {
        this.cdModel1 = cdModel1;
    }

    private List<CDModel2> cdModel2List;
    public List<CDModel2> getCdModel2List() {
        return cdModel2List;
    }

    public void setCdModel2List(List<CDModel2> cdModel2List) {
        this.cdModel2List = cdModel2List;
    }

    private static void destroyPrint(Class<?> clazz) {
        System.out.printf("%s Destroy...%n", clazz);
    }

    private static void constructPrint(Class<?> clazz) {
        System.out.printf("%s Construct...%n", clazz);
    }

    @Override
    public String toString() {
        return String.format("%s cdModel1:%s, cdModel2List:%s", this.getClass(), cdModel1, cdModel2List);
    }
}
