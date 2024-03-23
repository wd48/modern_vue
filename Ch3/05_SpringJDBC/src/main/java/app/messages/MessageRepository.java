package app.messages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MessageRepository {
    private DataSource dataSource;
    public MessageRepository(DataSource dataSource) {
      this.dataSource = dataSource;
    }
    private final static Log log = LogFactory.getLog(MessageRepository.class);

    private NamedParameterJdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

    public Message saveMessage(Message message) {
      GeneratedKeyHolder holder = new GeneratedKeyHolder();

      MapSqlParameterSource parameterSource = new MapSqlParameterSource();
      parameterSource.addValue("text", message.getText());
      parameterSource.addValue("createdDate", message.getCreatedDate());

      String insertSQL = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, :text, :createdDate)";
      try {
        this.jdbcTemplate.update(insertSQL, parameterSource, holder);
      } catch (DataAccessException e) {
        log.error("Failed to save message");
        return null;
      }
      return new Message(holder.getKey().intValue(), message.getText(), message.getCreatedDate());
    }
}
