package de.nordakademie.hausarbeit.service;

import java.util.List;

import de.nordakademie.hausarbeit.model.Pruefungsfach;

public interface PruefungsfaecherService {
	public List<Pruefungsfach> listPruefungen();
	public Pruefungsfach getPruefungsfach(Long pruefungsfachId);
}