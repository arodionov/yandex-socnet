package ua.yandex.shad.socnet.repository.group;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.yandex.shad.socnet.domain.group.Group;
import ua.yandex.shad.socnet.repository.DAOTestsTemplate;

/**
 *
 * @author Andrii_Rodionov
 */
public class GroupRepositoryJDBCTest extends DAOTestsTemplate {

    @Autowired
    private GroupRepository groupRepository;

    public GroupRepositoryJDBCTest() {
    }

    @Before
    public void setUp() {
         jdbcTemplate.execute("TRUNCATE TABLE Groups");
         jdbcTemplate.execute("TRUNCATE TABLE student_groups_junction");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNoExceptions() {        
        Group group = new Group();
        group.setGroupName("TestGroup");
        Assert.assertTrue(groupRepository.create(group));
    }

    @Test
    public void testAddStudentToGroupNoExceptions() {
        System.out.println("addStudentToGroup");
        Assert.assertTrue(groupRepository.addStudentToGroup(1, 1));
    }

}
