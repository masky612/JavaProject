/*
 * @author Xavier Nicolas Adèle Antoine
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Level;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOLevel.
 */
class DAOLevel extends DAOEntity<Level> {

	/**
	 * Instantiates a new DAO level.
	 *
	 * @param connection the connection
	 * @throws SQLException the SQL exception
	 */
	public DAOLevel(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final Level entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final Level entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final Level entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public Level find(final int id) {
		Level level = new Level();

		try {
			final String sql = "{call levelById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				level = new Level(id, resultSet.getString("code"), resultSet.getString("message"));
			}
			return level;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	@Override
	public Level find(final String code) {
		Level level = new Level();

		try {
			final String sql = "{call levelByCode(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, code);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				level = new Level(resultSet.getInt("id"), code, resultSet.getString("message"));
			}
			return level;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
