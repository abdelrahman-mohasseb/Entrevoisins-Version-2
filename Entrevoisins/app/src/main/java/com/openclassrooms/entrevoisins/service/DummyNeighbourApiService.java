package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> FavNeighbours = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void addToFavorits(Neighbour neighbour) {
            FavNeighbours.add(neighbour);
    }

    @Override
    public List<Neighbour> getfavoritNeighbours() {
        return FavNeighbours;
    }

    @Override
    public void deleteFavorit(Neighbour neighbour) {
        FavNeighbours.remove(neighbour);
    }


    @Override
    public Neighbour getNeighbourById(long id) {
        Neighbour neighbour = null;
        for(int i=0; i< neighbours.size(); i++){
            if(neighbours.get(i).getId() == id){
                neighbour = neighbours.get(i);
                break;
            }
        }
        return neighbour;
    }
}
