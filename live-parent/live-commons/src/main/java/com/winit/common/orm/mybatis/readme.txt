插件目前只提供了Oracle的版本

使用方法

在Mybatis的配置xml中配置拦截器插件:
<plugins>
    <plugin interceptor="com.winit.common.orm.mybatis.MyBatisPaginationPlugin">
        <property name="dialect" value="oracle"/>
    </plugin>
</plugins>
这里的MyBatisPaginationPlugin要使用完整的类路径，需要加上包路径。
增加dialect属性，使用时必须指定该属性，可选值为oracle,mysql,hsqldb,没有默认值，必须指定该属性。


示例：

@Test
public void testPageHelperByNamespaceAndRowBounds() throws Exception {
    //没有PageRequest不进行分页
    List<SysLoginLog> logs = sqlSession.selectList("findSysLoginLog2");
    Assert.assertNotEquals(10, logs.size());

    //使用PageRequest分页
    List<SysLoginLog> logs2 = sqlSession
            .selectList("findSysLoginLog2",null,new PageRequest(0,10));
    Assert.assertEquals(10, logs2.size());
}


示例的Mapper接口:

     /**
     * 根据查询条件查询登录日志
     * @param logip
     * @param username
     * @param loginDate
     * @param exitDate
     * @return
     */
    List<SysLoginLog> findSysLoginLog(@Param("logip") String logip,
                                      @Param("username") String username,
                                      @Param("loginDate") String loginDate,
                                      @Param("exitDate") String exitDate,
                                      @Param("logerr") String logerr);
    /**
     * 根据查询条件查询登录日志
     * @param logip
     * @param username
     * @param loginDate
     * @param exitDate
     * @return
     */
    List<SysLoginLog> findSysLoginLog(@Param("logip") String logip,
                                      @Param("username") String username,
                                      @Param("loginDate") String loginDate,
                                      @Param("exitDate") String exitDate,
                                      @Param("logerr") String logerr,
                                      RowBounds rowBounds);

示例Mapper接口对应的xml,两个接口方法对应同一个配置:

    <select id="findSysLoginLog" resultType="SysLoginLog">
        select * from sys_login_log a
        <if test="username != null and username != ''">
            left join sys_user b on (a.userid = b.username or a.userid = b.userid)
        </if>
        <where>
            <if test="logip!=null and logip != ''">
                a.logip like '%'||#{logip}||'%'
            </if>
            <if test="username != null and username != ''">
                and (b.username like '%'||#{username}||'%' or b.realname like '%'||#{username}||'%')
            </if>
            <if test="loginDate!=null and loginDate!=''">
                and to_date(substr(a.logindate,0,10),'yyyy-MM-dd') = to_date(#{loginDate},'yyyy-MM-dd')
            </if>
            <if test="exitDate!=null and exitDate!=''">
                and to_date(substr(a.EXITDATE,0,10),'yyyy-MM-dd') = to_date(#{exitDate},'yyyy-MM-dd')
            </if>
            <if test="logerr!=null and logerr!=''">
                and a.logerr like '%'||#{logerr}||'%'
            </if>
        </where>
        order by logid desc
    </select>

    <!-- namespace调用的方法 -->
    <select id="findSysLoginLog2" resultType="SysLoginLog">
        select * from sys_login_log order by logid desc
    </select>