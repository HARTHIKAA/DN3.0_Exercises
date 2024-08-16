JdbcTemplate jdbcTemplate = new JdbcTemplate(secondaryDataSource);
jdbcTemplate.execute("...");
