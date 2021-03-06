/*
 * BigBlueButton - http://www.bigbluebutton.org
 * 
 * Copyright (c) 2008-2009 by respective authors (see below). All rights reserved.
 * 
 * BigBlueButton is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Lesser General Public License as published by the Free Software 
 * Foundation; either version 3 of the License, or (at your option) any later 
 * version. 
 * 
 * BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along 
 * with BigBlueButton; if not, If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id: $
 */
package org.bigbluebutton.modules.chat.events
{
	import flash.events.Event;
	import flash.utils.Dictionary;
    
    /*****************************************************************************
    ;  cCHAT_ButtonEvent
    ;----------------------------------------------------------------------------
    ; DESCRIPTION
    ;   this class is used to add chat button event
    ;  
    ; HISTORY
    ; __date__ :        PTS:            Description
    ; 12-27-2010
    ******************************************************************************/
	public class cCHAT_ButtonEvent extends Event
	{
		public static const NEW_BUTTON:String = 'NEW_BUTTON';
        public static const CLOSE_BUTTON:String = 'CLOSE_BUTTON';
        public static const SWITCH_BUTTON:String = 'SWITCH_BUTTON';
        
        public var sender:String ;
        public var name:String ;
        public var isRecording:Boolean ;
        public var receiver:String ;
        
		/*****************************************************************************
        ;  cCHAT_ButtonEvent
        ;----------------------------------------------------------------------------
        ; DESCRIPTION
        ;   this routine is the constructor of the class
        ;   
        ; RETURNS : N/A
        ;
        ; INTERFACE NOTES
        ;   INPUT
        ;
        ; IMPLEMENTATION
        ;
        ; HISTORY
        ; __date__ :        PTS:            Description
        ; 12-27-2010
        ******************************************************************************/
		public function cCHAT_ButtonEvent(type:String, bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}/** END FUNCTION 'cCHAT_ButtonEvent' **/
		
	}/** END CLASS 'cCHAT_ButtonEvent' **/
}