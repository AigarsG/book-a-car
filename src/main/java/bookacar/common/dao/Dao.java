package bookacar.common.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookacar.common.database.DatabaseConnectionPool;

public abstract class Dao<T> {

	// Override this to create corresponding object
	protected abstract T rowToObj(ResultSet rs) throws SQLException;

	protected List<T> executeQuery(String query, Object args[],
			boolean skipResultSet) {
		List<T> res = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// handle connection
		try {

			conn = DatabaseConnectionPool.getConnection();

			// handle prepared statement
			try {

				pstmt = conn.prepareStatement(query);
				// set args
				for (int i = 0; i < args.length; i++) {
					Object arg = args[i];
					if (arg instanceof Integer) {
						pstmt.setInt(i + 1, (Integer) arg);
					} else if (arg instanceof String) {
						pstmt.setString(i + 1, (String) arg);
					} else if (arg instanceof Date) {
						pstmt.setDate(i + 1, (Date) arg);
					}
				}
				rs = pstmt.executeQuery();
				if (!skipResultSet) {
					// handle result set
					try {
						// while results exist, add to list
						while (rs.next()) {
							T t = rowToObj(rs);
							res.add(t);
						}
					} catch (Exception e) {
						System.err.println(e);
					} finally {
						if (rs != null) {
							try {
								rs.close();
							} catch (Exception e) {
								System.err.println(e);
							}
						}
					}
				}

			} catch (Exception e) {
				System.err.println(e);
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}

		return res;
	}
}
