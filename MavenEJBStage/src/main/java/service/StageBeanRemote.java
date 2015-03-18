package service;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.Remote;

import meserreurs.MonException;
import metier.Stage;

@Remote
public interface StageBeanRemote {

	/**
	 * ins�re un stage 
	 * @throws MonException
	 */
	public void insertionStage(Stage unS) throws MonException;

	/**
	 * affiche la liste des stages
	 * @param unS  de type Stage
	 * @throws MonException, ParseException
	 */

	
	public ArrayList<Stage> rechercheLesStages() throws Exception,MonException, ParseException;
	
	/**
	 * recherche  tous les stages
	 @throws MonException
	 * @throws Exception
	 * @throws ParseException
	 */
	 
	public Stage rechercheStageId(String id) throws MonException,Exception,ParseException;

	/**
	 * @param id num�ro  de stage
	 * @throws MonException
	 * @throws Exception
	 * @throws ParseException
	 */
	public Stage rechercheStageLibelle(String libelle) throws MonException,Exception,ParseException;
	
	/**
	 * @param ilibelle libell� de stage
	 * @throws MonException
	 * @throws Exception
	 * @throws ParseException
	 */

	public void suppressionStage(String id) throws MonException,Exception;
	
	/**
	 * modification d'un stage 
	 * @param unstage  
	 * @throws MonException
	 */

	public void modificationStage(Stage unstage) throws MonException, Exception;
	
	
}
