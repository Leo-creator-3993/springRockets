package com.future.spring.rocket.proxy.lazyloadtest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

public class MyBolgModel {
    private String blogTitle;
    private BlogContentModel blogContentModel;

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public BlogContentModel getBlogContentModel() {
        return blogContentModel;
    }

    public void setBlogContentModel(BlogContentModel blogContentModel) {
        this.blogContentModel = blogContentModel;
    }

    public MyBolgModel(String blogTitle) {
        this.blogTitle = blogTitle;
        //this.blogContentModel = getMyBlogContentModel();
        this.blogContentModel = getMyBlogContentModel2();
    }

    private BlogContentModel getMyBlogContentModel() {
        BlogContentModel blogContentModel1 =  new BlogContentModel();
        blogContentModel1.setBlogContent("foo foo...");
        return blogContentModel1;
    }

    private BlogContentModel getMyBlogContentModel2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BlogContentModel.class);
        enhancer.setCallback(new LazyLoader() {
            @Override
            public Object loadObject() throws Exception {
                 System.out.println("调用 ==> lazyLoader...");
                 BlogContentModel blogContentModel1 = new BlogContentModel();
                 blogContentModel1.setBlogContent("foo foo...");
                 return blogContentModel1;
            }
        });
        return (BlogContentModel) enhancer.create();
    }


    public static class BlogContentModel {
        private String blogContent;

        public BlogContentModel() {
        }

        public BlogContentModel(String blogContent) {
            this.blogContent = blogContent;
        }

        public String getBlogContent() {
            return blogContent;
        }

        public void setBlogContent(String blogContent) {
            this.blogContent = blogContent;
        }
    }
}
