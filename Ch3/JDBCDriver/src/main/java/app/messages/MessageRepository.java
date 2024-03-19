package app.messages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MessageRepository {
    private DataSource dataSource;
    public MessageRepository(DataSource dataSource) {
      this.dataSource = dataSource;
    }

    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public Message saveMessage(Message message) {
        // Save message to a database
      Connection connection = DataSourceUtils.getConnection(dataSource);

      try {
        String insertSql = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
        // setting SQL parameter
        ps.setString(1, message.getText());
        ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
          ResultSet result = ps.getGeneratedKeys();
          if (result.next()) {
            int id = result.getInt(1);
            return new Message(id, message.getText(), message.getCreatedDate());
          } else {
            log.error("Failed to retrieve id. No row in result set");
            return null;
          }
        } else {
          return null;
        }
      } catch (SQLException ex) {
        log.error("Failed to save message", ex);
        try {
          connection.close();
        } catch (SQLException e) {
          log.error("Failed to close connection", e);
        }

      } finally {
        DataSourceUtils.releaseConnection(connection, dataSource);
      }
      return null;
    }
}
