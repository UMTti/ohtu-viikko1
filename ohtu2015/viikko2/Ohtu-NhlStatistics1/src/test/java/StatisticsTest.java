/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtuesimerkki.Reader;
import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pihla
 */
public class StatisticsTest {
    
    static Statistics stats;
    static Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest(){
        stats = new Statistics(readerStub);
    }

    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Test
    public void searchLoytyy(){
        String name = stats.search("Semenko").getName();
        assertEquals("Semenko", name);       
    }
    
    @Test
    public void searchEiloydy(){
        assertEquals(null, stats.search("Ei varmaan ole"));
    }
    
    @Test
    public void testaaTeam(){
       List<Player> teami = stats.team("EDM");
       assertEquals(3, teami.size());    
    }
    
    @Test
    public void testaaTopScores(){
        List<Player> topit = stats.topScorers(3);
        Player eka = topit.get(0);
        assertEquals("Gretzky", eka.getName());
        
    }
    
    /*@AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

}
