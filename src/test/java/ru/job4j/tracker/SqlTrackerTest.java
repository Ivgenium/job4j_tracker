package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceOneItemAnotherThenTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        Item item2 = new Item("item2");
        assertThat(tracker.replace(item1.getId(), item2)).isTrue();
    }

    @Test
    public void whenReplaceOneItemAnotherThenMustBeTheSameValues() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        Item item2 = new Item("item2");
        tracker.replace(item1.getId(), item2);
        item1 = tracker.findById(item1.getId());
        assertThat(item1.getName()).isEqualTo(item2.getName());
        assertThat(item1.getCreated()).isEqualTo(item2.getCreated());
    }

    @Test
    public void whenSave3ItemsAndDelete1ThenMustBe2Items() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        List<Item> temp = new ArrayList<>();
        temp.add(item1);
        temp.add(item3);
        assertThat(tracker.findAll()).isEqualTo(temp);
    }

    @Test
    public void whenSave3ItemsAndFindAllThenMustBe3Items() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> temp = new ArrayList<>();
        temp.add(item1);
        temp.add(item2);
        temp.add(item3);
        assertThat(tracker.findAll()).isEqualTo(temp);
    }

    @Test
    public void whenSave3ItemsAndFindByNameThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> temp = new ArrayList<>();
        temp.add(item3);
        assertThat(tracker.findByName(item3.getName())).isEqualTo(temp);
    }

    @Test
    public void whenSave3ItemsAndFindByIdThenMustBeSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item1.getId())).isEqualTo(item1);
    }
}