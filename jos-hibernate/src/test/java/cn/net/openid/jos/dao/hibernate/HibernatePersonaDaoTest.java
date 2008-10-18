/**
 * Created on 2008-10-18 01:15:12
 */
package cn.net.openid.jos.dao.hibernate;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cn.net.openid.jos.dao.PersonaDao;
import cn.net.openid.jos.domain.Attribute;
import cn.net.openid.jos.domain.Persona;

/**
 * @author Sutra Zhou
 * 
 */
@ContextConfiguration
public class HibernatePersonaDaoTest extends AbstractHibernateDaoTest {
	@SuppressWarnings("unused")
	private static final Log log = LogFactory
			.getLog(HibernatePersonaDaoTest.class);

	@Autowired
	private PersonaDao personaDao;

	@Test
	public void testInsertPersona() {
		Persona persona = new Persona();
		persona.setName("testPersonaName");
		Attribute attribute = new Attribute(persona, "testAlias",
				"testTypeUri", new String[] { "value1", "value2" });
		persona.addAttribute(attribute);
		personaDao.insertPersona(persona);
		String id = persona.getId();
		assertNotNull(id);

		Persona persona1 = personaDao.getPersona(id);
		Set<Attribute> attributes1 = persona1.getAttributes();
		assertNotNull(attributes1);
	}
}
