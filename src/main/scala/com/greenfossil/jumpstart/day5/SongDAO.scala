package com.greenfossil.jumpstart.day5

import com.greenfossil.sqlview2.*
import com.greenfossil.jumpstart.day5.SongSchema.*

import java.sql.Connection
import scala.util.Try

object SongDAO:

  /**
   * Queries the first song that matches the where clause
   */
  def findSong(whereFn: SONG_TABLE.type => WhereClause)(using connection: Connection): Try[Song] = {
    Select(SONG_TABLE.id, SONG_TABLE.title, SONG_TABLE.artist, SONG_TABLE.year).from(SONG_TABLE).where(whereFn(SONG_TABLE)).executeFirst[SONG]
  }

  /**
   * Queries `Song.json` for the value of the `img_url` field
   */
  def findImageUrlOfSong(whereFn: SONG_TABLE.type => WhereClause)(using connection: Connection): Try[String] = ???

  /**
   * Insert record into the Song table
   * @return ID of the new song record
   */
  def createSong(song: String, artist: String, year: Int)(using connection: Connection): Try[Long] = ???

  /**
   * Update the row where the song ID matches
   * @return Num of updated rows
   */
  def updateSong(songId: Long, song: String, artist: String, year: Int)(using connection: Connection): Try[Int] = ???

  /**
   * Delete the row where the song ID matches
   * @return Num of updated rows
   */
  def deleteSong(songId: Long)(using connection: Connection): Try[Int] = ???

