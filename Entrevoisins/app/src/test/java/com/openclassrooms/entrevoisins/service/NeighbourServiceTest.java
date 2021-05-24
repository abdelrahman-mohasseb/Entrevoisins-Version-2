package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }
    @Test
    public void addNeighbourfromFavorits(){
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addToFavorits(neighbour);
        List<Neighbour> Favneighbours = service.getfavoritNeighbours();
        assertThat(Favneighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(neighbour));
    }

    @Test
    public void deleteNeighbourfromFavorits(){
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addToFavorits(neighbour);
        Neighbour neighbourToDelete = service.getfavoritNeighbours().get(0);
        service.deleteFavorit(neighbourToDelete);
        assertFalse(service.getfavoritNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void getFavNeighbours(){
        Neighbour neighbour = service.getNeighbours().get(0);
        Neighbour neighbour1 = service.getNeighbours().get(1);
        service.addToFavorits(neighbour);
        service.addToFavorits(neighbour1);
        List<Neighbour> Favneighbours = service.getfavoritNeighbours();
        List<Neighbour> expectedFavNeighbours = new ArrayList<>();
        expectedFavNeighbours.add(neighbour);
        expectedFavNeighbours.add(neighbour1);
        assertThat(Favneighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavNeighbours.toArray()));
    }

}
