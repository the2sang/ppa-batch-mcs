package com.kepco.ppa.web.batch.writer;

//@Service
//@NoArgsConstructor
public class EmailToTbTaxBillInfoEncInit {
    //    @Autowired
    //    public DataSource dataSource;
    //
    //
    //    public TbTaxBillInfoEncVO initalTbTaxBillInfoEncFromEmail() throws Exception {
    //        String uuid = UUID.randomUUID().toString();
    //
    //
    //
    //        return null;
    //
    //            //uuid 의미나 규칙에 따라서 DB에서 가져와야 할 수 있음..
    ////        if ( uuid == null || uuid.isEmpty() || uuid.equals("0000008099999999") || uuid.equals("0000009099999999") ){
    ////            uuid = getMakeUuid(dataSource, uuid);
    ////        }
    //
    //
    //
    //    }
    //
    //
    //    public String getMakeUuid(DataSource dataSource, String uuid) throws SQLException, Exception {
    //
    //
    //        StringBuilder sb = new StringBuilder();
    //        OracleConnection conn = (OracleConnection)dataSource.getConnection();
    //        PreparedStatement pstmt = conn.prepareStatement(sb.toString());
    //
    //        //sb.append("\n SELECT '"+uuid.substring(0,8)+"' || LPAD(SQ_UUID.NEXTVAL, 8, 0) FROM DUAL");  //개발을 위해 주석처리..실제 운영테스트시 해제 필요
    //
    //        sb.append("\n SELECT '"+uuid.substring(0,8)+"' || LPAD(CUSTOMER_INPUT_SEQ.NEXTVAL, 8, 0) FROM DUAL"); // 임의로 값을 설정함..
    //
    //        ResultSet rs = pstmt.executeQuery();
    //
    //        try {
    //
    //            if (rs.next()) {
    //                uuid = rs.getString(1);
    //            }
    //            //ConnectionDB.closeAll(conn, rs, pstmt);
    //        } catch (SQLException se){
    //            //ConnectionDB.closeAll(conn, rs, pstmt);
    //            //Env.errorLogger.info("\n ["+this.getClass()+"]\n " + "SQLException >>>>> " + se);
    //        } catch (Exception e){
    //            //ConnectionDB.closeAll(conn, rs, pstmt);
    //            //Env.errorLogger.info("\n ["+this.getClass()+"]\n " + "Exception >>>>> " + e);
    //
    //        } finally {
    //            try {
    //               closeAll(conn, rs, pstmt);
    //
    //            } catch (Exception e){System.out.println(e.toString()); }
    //        }
    //        return uuid;
    //    }
    //
    //
    //    public static void closeRS(ResultSet rs) {
    //        try {
    //            if ( rs != null ) rs.close();
    //        } catch(SQLException e) {
    //            System.out.println("closeRS error >>>>> " + e);
    //        }
    //    }
    //
    //
    //    public static void closePS(PreparedStatement pstmt) {
    //        try {
    //            if ( pstmt != null ) pstmt.close();
    //        } catch(SQLException e) {
    //            System.out.println("closePS error >>>>> " + e);
    //        }
    //    }
    //
    //
    //    public static void closeDB(OracleConnection conn) {
    //        try {
    //            if ( conn != null ) conn.close();
    //        } catch(SQLException e) {
    //            System.out.println("closeDB error >>>>> " + e);
    //        }
    //    }
    //
    //    public static void closeAll(OracleConnection conn, ResultSet rs, PreparedStatement pstmt) {
    //        closeRS(rs);
    //        closePS(pstmt);
    //        closeDB(conn);
    //    }

}
