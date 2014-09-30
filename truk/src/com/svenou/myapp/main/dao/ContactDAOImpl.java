package com.svenou.myapp.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.svenou.myapp.main.dao.iface.ContactDAO;
import com.svenou.myapp.main.model.Contact;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class ContactDAOImpl extends NamedParameterJdbcDaoSupport implements ContactDAO {

	private static Log log = LogFactory.getLog(ContactDAOImpl.class);
	private static final RowMapper<Contact> CONTACK__ROW_MAPPER =  BeanPropertyRowMapper.newInstance(Contact.class);

	private static  final String UPDATE_CONTACT = "UPDATE contact SET name=: name, email= :email, address= :address,telephone= :telephone WHERE contact_id= :contactId";
	private static  final String INSER_CONTACT = "INSERT INTO contact (name, email, address, telephone) VALUES (?, ?, ?, ?)";
	@Override
	public int saveOrUpdate(Contact contact) {
		if (contact.getContactId() > 0) {
			// update
			log.info("update contact:"+contact);
			return this.getNamedParameterJdbcTemplate().update(UPDATE_CONTACT,new BeanPropertySqlParameterSource(contact));
		} else {
			// insert
			log.info("insert contact:"+contact);
			return this.getJdbcTemplate().update(INSER_CONTACT, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getTelephone());
		}
		
	}

	
	private static final String DELETE_CONTACT ="DELETE FROM contact WHERE contact_id= :contactId";
	@Override
	public int delete(int contactId) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("contactId", contactId);
		log.info("delete contact ,contactId:"+contactId);
		return this.getNamedParameterJdbcTemplate().update(DELETE_CONTACT, paramMap);
	}

	private static final String SELECT_CONTCT_LIST ="SELECT * FROM contact";
	@Override
	public List<Contact> list() {
//		String sql = "SELECT * FROM contact";
//		List<Contact> listContact = this.getJdbcTemplate().query(sql, new RowMapper<Contact>() {
//
//			@Override
//			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Contact aContact = new Contact();
//	
//				aContact.setId(rs.getInt("contact_id"));
//				aContact.setName(rs.getString("name"));
//				aContact.setEmail(rs.getString("email"));
//				aContact.setAddress(rs.getString("address"));
//				aContact.setTelephone(rs.getString("telephone"));
//				
//				return aContact;
//			}
//			
//		});
		log.info("find contact  list");
		List<Contact> listContact = this.getNamedParameterJdbcTemplate().query(SELECT_CONTCT_LIST, CONTACK__ROW_MAPPER);
		
		return listContact;
	}

	private static final String SELECT_CONTCT_BY_ID = "SELECT * FROM contact WHERE contact_id= :contactId";
	@Override
	public Contact get(int contactId) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("contactId", contactId);
		log.info("find contact ,contactId:"+contactId);
		return this.getNamedParameterJdbcTemplate().queryForObject(SELECT_CONTCT_BY_ID, paramMap, Contact.class);
//		String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
//		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<Contact>() {
//
//			@Override
//			public Contact extractData(ResultSet rs) throws SQLException,
//					DataAccessException {
//				if (rs.next()) {
//					Contact contact = new Contact();
//					contact.setId(rs.getInt("contact_id"));
//					contact.setName(rs.getString("name"));
//					contact.setEmail(rs.getString("email"));
//					contact.setAddress(rs.getString("address"));
//					contact.setTelephone(rs.getString("telephone"));
//					return contact;
//				}
//				
//				return null;
//			}
//			
//		});
		
		
		
	}

}
