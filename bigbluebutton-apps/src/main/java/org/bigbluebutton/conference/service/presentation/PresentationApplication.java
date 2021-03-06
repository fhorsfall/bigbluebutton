/** 
* ===License Header===
*
* BigBlueButton open source conferencing system - http://www.bigbluebutton.org/
*
* Copyright (c) 2010 BigBlueButton Inc. and by respective authors (see below).
*
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License as published by the Free Software
* Foundation; either version 2.1 of the License, or (at your option) any later
* version.
*
* BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
* PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License along
* with BigBlueButton; if not, see <http://www.gnu.org/licenses/>.
* 
* ===License Header===
*/

package org.bigbluebutton.conference.service.presentation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.red5.logging.Red5LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
public class PresentationApplication {

	private static Logger log = Red5LoggerFactory.getLogger( PresentationApplication.class, "bigbluebutton" );	
		
	private static final String APP = "PRESENTATION";
	private PresentationRoomsManager roomsManager;
	
	public boolean createRoom(String name) {
		roomsManager.addRoom(new PresentationRoom(name));
		return true;
	}
	
	public boolean destroyRoom(String name) {
		if (roomsManager.hasRoom(name)) {
			roomsManager.removeRoom(name);
		}
		return true;
	}
	
	public boolean hasRoom(String name) {
		return roomsManager.hasRoom(name);
	}
	
	public boolean addRoomListener(String room, IPresentationRoomListener listener) {
		if (roomsManager.hasRoom(room)){
			roomsManager.addRoomListener(room, listener);
			return true;
		}
		log.warn("Adding listener to a non-existant room {}",room);
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void sendUpdateMessage(Map message){
		String room = (String) message.get("room");
		if (roomsManager.hasRoom(room)){
			roomsManager.sendUpdateMessage(message);
			return;
		}
		log.warn("Sending update message to a non-existant room {}",room);	
	}
	
	public ArrayList getCurrentPresenter(String room){
		if (roomsManager.hasRoom(room)){
			return roomsManager.getCurrentPresenter(room);			
		}
		log.warn("Getting presenter on a non-existant room {}",room);
		return null;
	}
	
	public ArrayList<String> getPresentations(String room){
	   if (roomsManager.hasRoom(room)){
            return roomsManager.getPresentations(room);           
        }
        log.warn("Getting presentations on a non-existant room {}",room);
        return null;
	}
	
	public void removePresentation(String room, String name){
       if (roomsManager.hasRoom(room)){
            roomsManager.removePresentation(room, name);           
        }
        log.warn("Removing presentation from a non-existant room {}",room);
        
    }
	
	public int getCurrentSlide(String room){
		if (roomsManager.hasRoom(room)){
			return roomsManager.getCurrentSlide(room);			
		}
		log.warn("Getting slide on a non-existant room {}",room);
		return -1;
	}
	
	public String getCurrentPresentation(String room){
		if (roomsManager.hasRoom(room)){
			return roomsManager.getCurrentPresentation(room);			
		}
		log.warn("Getting current presentation on a non-existant room {}",room);
		return null;
	}
	
	public Map getPresenterSettings(String room){
		if (roomsManager.hasRoom(room)){
			return roomsManager.getPresenterSettings(room);			
		}
		log.warn("Getting settings information on a non-existant room {}",room);
		return null;
	}
	
	public Boolean getSharingPresentation(String room){
		if (roomsManager.hasRoom(room)){
			return roomsManager.getSharingPresentation(room);			
		}
		log.warn("Getting share information on a non-existant room {}",room);
		return null;
	}
	
	public void resizeAndMoveSlide(String room, Double xOffset, Double yOffset, Double widthRatio, Double heightRatio) {
		if (roomsManager.hasRoom(room)){
			log.debug("Request to resize and move slide["+xOffset+","+yOffset+","+widthRatio+","+heightRatio+"]");
			roomsManager.resizeAndMoveSlide(room, xOffset, yOffset, widthRatio, heightRatio);
			return;
		}
		log.warn("resizeAndMoveSlide on a non-existant room {}",room);		
	}
	
	public void assignPresenter(String room, ArrayList presenter){
		if (roomsManager.hasRoom(room)){
			roomsManager.assignPresenter(room, presenter);
			return;
		}
		log.warn("Assigning presenter on a non-existant room {}",room);	
	}
	
	public void gotoSlide(String room, int slide){
		if (roomsManager.hasRoom(room)){
			log.debug("Request to go to slide {} for room {}",slide,room);
			roomsManager.gotoSlide(room, slide);
			return;
		}
		log.warn("Changing slide on a non-existant room {}",room);	
	}
	
	public void sharePresentation(String room, String presentationName, Boolean share){
		if (roomsManager.hasRoom(room)){
			log.debug("Request to share presentation "+presentationName+" "+share+" for room "+room);
			roomsManager.sharePresentation(room, presentationName, share);
			return;
		}
		log.warn("Sharing presentation on a non-existant room {}",room);	
	}
	
	public void setRoomsManager(PresentationRoomsManager r) {
		log.debug("Setting room manager");
		roomsManager = r;
		log.debug("Done setting room manager");
	}
	
    /*****************************************************************************
    ;  shareUpdatePresenterViewDimension
    ;----------------------------------------------------------------------------
    ; DESCRIPTION
    ;   This routine is use to call 'shareUpdatePresenterViewDimension' from 
    ;	roomManager object.
    ;
    ; RETURNS
    ;
    ; INTERFACE NOTES
    ;   INPUT
    ;       curSlideWidth   : the current slide width
    ;       curSlideHeight  : the current slide height
    ;       viewPortWidth   : the view port width
    ;       viewPortHeight  : the view port height
    ;
    ; IMPLEMENTATION
    ;	call 'shareUpdatePresenterViewDimension' from RoomManger to share the 
    ;	presenter view port information. 
    ; HISTORY
    ; __date__ :        PTS:            Description
    ; 2011.01.27                        Full Screen Presentation window
    ;
    ******************************************************************************/
    public void shareUpdatePresenterViewDimension(
    								String room, Double curSlideWidth ,
    								Double curSlideHeight, Double viewPortWidth,
    								Double viewPortHeight
    								) {
    	log.debug("Share presenter view port information");
    	if (null == room)
    	{
    		log.error("The parameter room is null");
    		return;
    	}
        roomsManager.shareUpdatePresenterViewDimension(
        									room,curSlideWidth ,curSlideHeight,
        									viewPortWidth,viewPortHeight
        									);
    }
    /** END Function : shareUpdatePresenterViewDimension */
    
    /*****************************************************************************
    ;  setCurrentPresentationPosition
    ;----------------------------------------------------------------------------
    ; DESCRIPTION
    ;   This routine is use to call 'setCurrentPresentationPosition' from 
    ;	roomManager object to set the view port information.
    ;
    ; RETURNS:	N/A
    ;
    ; INTERFACE NOTES
    ;   INPUT
    ;       curSlideWidth   : the current slide width
    ;       curSlideHeight  : the current slide height
    ;       viewPortWidth   : the view port width
    ;       viewPortHeight  : the view port height
    ;
    ; IMPLEMENTATION
    ;	- check the parameter
    ;	- call 'setCurrentPresentationPosition' from RoomManager
    ;	to set the presenter view port information.
    ; HISTORY
    ; __date__ :        PTS:            Description
    ; 2011.01.27                        Full Screen Presentation window
    ;
    *****************************************************************************/
    public void setCurrentPresentationPosition(
    								String room, Double curSlideWidth, 
    								Double curSlideHeight, Double viewPortWidth,
    								Double viewPortHeight
    								){
    	log.debug("Setting presenter view port information");
    	if (null == room)
    	{
    		log.error("The parameter room is null");
    		return;
    	}
        roomsManager.setCurrentPresentationPosition(
        							room,curSlideWidth,curSlideHeight,
        							viewPortWidth,viewPortHeight
        							) ;
    }
    /** END Function : setCurrentPresentationPosition */
    
    /*****************************************************************************
    ;  getCurrentPresenterPosition
    ;----------------------------------------------------------------------------
    ; DESCRIPTION
    ;   This routine is use to call 'getCurrentPresenterPosition' from 
    ;	roomManager object to get the presenter view port information.
    ;
    ; RETURNS
    ;	return ArrayList of the presenter view port information
    ;	or null if the parameter room is null.
    ; INTERFACE NOTES
    ;   INPUT
    ;       room    : room name
    ;
    ; IMPLEMENTATION
    ;	- check the parameter room
    ;	- call 'getCurrentPresenterPosition' from RoomManager to get
    ;	the presenter view port information.
    ; HISTORY
    ; __date__ :        PTS:            Description
    ; 2011.01.27                        Full Screen Presentation window
    ;
    *****************************************************************************/
    public ArrayList<Double> getCurrentPresenterPosition(String room){
    	log.debug("Getting presenter view port information");
    	if (null == room)
    	{
    		log.error("The parameter room is null");
    		return null;
    	}
        return roomsManager.getCurrentPresenterPosition(room) ;
    }
    /** END Function : getCurrentPresenterPosition */
}
