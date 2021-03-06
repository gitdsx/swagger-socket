/**
 *  Copyright 2015 Reverb Technologies, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.wordnik.swaggersocket.client.tests

import org.slf4j.LoggerFactory
import javax.ws.rs.{GET, POST, Produces, Path}

@Path("/")
@Produces(Array("application/json"))
class RootResource /* extend SwaggerSocket */ {

  val logger = LoggerFactory.getLogger(classOf[RootResource])

  @Path("/a")
  @POST
  def yo(m: String): String = {
    m
  }
  @Path("/b")
  @POST
  def yob(m: String): String = {
    m
  }

  @Path("/c")
  @POST
  def yoc(m: String): String = {
    "root::" + m
  }

  @Path("/pet.json/{yo}")
  @GET
  def yod(): String = {
    "root::zzzzzz!"
  }

  @Path("/e")
  @POST
  def yoe(m: String): String = {
    if (m == "secret") {
      throw new RuntimeException("no secret");
    }
    m
  }

  @Path("/f")
  @POST
  @Produces(Array("text/plain"))
  def yof(m: String): String = {
    "peace"
  }
}