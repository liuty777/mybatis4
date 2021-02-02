package com.atguigu.mybatis.test;

import com.atguigu.mybatis.entities.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException, IOException {
        //设置MyBatis全局配置文件的路径
        String resource = "mybatis-config.xml";
        //读取MyBatis的全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            PageHelper.startPage(4,2);
            List<Employee> employees = mapper.getEmployees();
            PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
            System.out.println("当前是:"+pageInfo.getPageNum());
            System.out.println("每页显示的条数是："+pageInfo.getPageSize());
            System.out.println("总页数："+pageInfo.getPages());
            System.out.println("总记录数："+pageInfo.getTotal());
            System.out.println("是否有上一页："+pageInfo.isHasPreviousPage());
            System.out.println("获取上一页："+pageInfo.getPrePage());
            System.out.println("是否有下一页："+pageInfo.isHasNextPage());
            System.out.println("获取下一页："+pageInfo.getNextPage());
            System.out.println("是否是第一页："+pageInfo.isIsFirstPage());
            System.out.println("是否是最后一页："+pageInfo.isIsLastPage());
            System.out.println("获取当前页中的第一个页码："+pageInfo.getNavigateFirstPage());
            System.out.println("获取当前页中的最后页码："+pageInfo.getNavigateLastPage());
            System.out.println("每页让显示的页码数量是："+pageInfo.getNavigatePages()+"个");
            System.out.println("当前页中的数据是：");
            for(Employee employee:employees){
                System.out.println(employee);
            }
            System.out.println("页码信息是：");
            int[] navigatepageNums = pageInfo.getNavigatepageNums();
            for(int n:navigatepageNums){
                System.out.println(n+" ");
            }

        }finally {
            sqlSession.close();
        }
    }

}
