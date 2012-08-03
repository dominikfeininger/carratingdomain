/*dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
		    pooled = true
		    dbCreate = "update"
            //this line makes it run
            url = "jdbc:mysql://localhost/db"
		    //url = "jdbc:mysql://dev.server/db"
		    driverClassName = "com.mysql.jdbc.Driver"
		    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
		    username = "user"
		    password = "pass"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
		    driverClassName = "org.hsqldb.jdbcDriver"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
		    pooled = true
		    dbCreate = "update"
		    url = "jdbc:mysql://prod.server/db"
		    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
		    username = "user"
		    password = "pass"
        }
    }
}
*/
dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings

//MySql settings
environments {
    development {
        dataSource {
            dbCreate = "create" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/dbrep?useUnicode=yes&characterEncoding=UTF-8"
            username = "root"
            password = ""
        }
        hibernate {
            show_sql = true
        }
    }
    test {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/dbrep?useUnicode=yes&characterEncoding=UTF-8"
            username = "user"
            password = "pass"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/dbrep?useUnicode=yes&characterEncoding=UTF-8"
            username = "user"
            password = "pass"
        }
    }
}