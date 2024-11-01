package com.future.spring.rocket.jdbctemplate;

import com.future.spring.rocket.jdbctemplate.model.DbModel;
import com.future.spring.rocket.jdbctemplate.source.DbSource;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import reactor.util.annotation.Nullable;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestJdbcTemplateMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void testInit() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int affectedRow = jdbcTemplate.update("Insert into t_user(name) value('LeoLeo'),('FooFoo'),('StephZ'),('Jay')");
        System.out.println("影响行数 ==> " + affectedRow);
    }


    @Test
    public void test1() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(resultList);
    }

    @Test
    public void test2() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int affectedRow = jdbcTemplate.update("Insert into t_user(name) value(?)", "LinX");
        System.out.println("影响行数 ==> " + affectedRow);
    }

    @Test
    public void test3() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int affectedRow = jdbcTemplate.update("Insert into t_user(name) value(?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, "HongX");
            }
        });
        System.out.println("影响行数 ==> " + affectedRow);
    }

    @Test
    public void test4() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "Insert into t_user(name) value(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowCount = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                //手动创建PreparedStatement，注意第二个参数：Statement.RETURN_GENERATED_KEYS
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "获取自增列的值");
                return ps;
            }
        }, keyHolder);
        System.out.println("新记录id：" + keyHolder.getKey().intValue());
    }

    @Test
    public void test5() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Object[]> list = Arrays.asList(new Object[]{"Apple"}, new Object[]{"Pear"}, new Object[]{"Banana"});
        int[] result  = jdbcTemplate.batchUpdate("Insert into t_user(name) value(?)", list);
        System.out.println("结果 ==>" + Arrays.toString(result));
    }

    @Test
    public void test6() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String result = jdbcTemplate.queryForObject("select name from t_user where id = ?", String.class, 1);
        System.out.println("结果 ==> " + result);
    }

    @Test
    public void test6_exception() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String result = jdbcTemplate.queryForObject("select name from t_user where id = ?", String.class, -1);
        System.out.println("结果 ==> " + result);
    }

    @Test
    public void test7() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<String> queryResult1 = jdbcTemplate.queryForList("select name from t_user where id>1", String.class);
        System.out.println("==>1 " + queryResult1);

        List<String> queryResult2 = jdbcTemplate.queryForList("select name from t_user where id>?", String.class, 1);
        System.out.println("==>2 " + queryResult2);

        List<String> queryResult3 = jdbcTemplate.queryForList("select name from t_user where id>?",new Object[]{1}, String.class);
        System.out.println("==>3 " + queryResult3);

        List<String> queryResult4 = jdbcTemplate.queryForList("select name from t_user where id>?", new Object[]{1}, new int[]{java.sql.Types.INTEGER}, String.class);
        System.out.println("==>4 " + queryResult4);
    }

    @Test
    public void test8() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id = ?";

        DbModel dbModel = jdbcTemplate.queryForObject(sql, new RowMapper<DbModel>() {
            @Override
            public DbModel mapRow(ResultSet rs, int i) throws SQLException {
                DbModel dbModel1 = new DbModel();
                dbModel1.setId(rs.getInt(1));
                dbModel1.setName(rs.getString(2));
                return dbModel1;
            }
        }, 1);
        System.out.println("dbModel ==> " + dbModel);
    }


    @Test
    public void test9() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id = ?";
        RowMapper<DbModel> rowMapper = new BeanPropertyRowMapper<>(DbModel.class);
        DbModel dbModel = jdbcTemplate.queryForObject(sql, rowMapper, 3);
        System.out.println("==> " + dbModel);
    }

    @Test
    public void test10() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id>?";
        List<Map<String,Object>> result = jdbcTemplate.queryForList(sql, 1);
        System.out.println("==> " + result);
    }

    @Test
    public void test11() {
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id>?";
        List<DbModel> dbModelList = jdbcTemplate.query(sql, new RowMapper<DbModel>() {

            @Nullable
            @Override
            public DbModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                DbModel user = new DbModel();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                return user;
            }

        }, 7);
        System.out.println("==> " + dbModelList);
    }

    @Test
    public void test12() {
        //使用方便,自动映射与组装
        DataSource dataSource = DbSource.getINSTANCE().get();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select id,name from t_user where id>?";
        List<DbModel> dbModelList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DbModel.class), 8);
        System.out.println("==> " + dbModelList);
    }
}
