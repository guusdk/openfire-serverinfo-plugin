/*
 * Copyright (C) 2017 Guus der Kinderen. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.goodbytes.openfire.plugins.serverinfo;

import org.jivesoftware.admin.AuthCheckFilter;
import org.jivesoftware.openfire.SessionManager;
import org.jivesoftware.util.cache.CacheFactory;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

import static org.jivesoftware.openfire.XMPPServer.getInstance;

/**
 * Generates a JSON object that contains information regarding the XMPP domain that this plugin is loaded into.
 *
 * @see <a href="https://github.com/ThomasLeister/mod_serverinfo">Thomas Lesiter's 'mod_serverinfo' for Prosody</a>
 * @author Guus der Kinderen, guus@goodbytes.nl
 */
public class ServerInfoServlet extends HttpServlet
{
    private static final Logger Log = LoggerFactory.getLogger( ServerInfoServlet.class );

    @Override
    public void destroy()
    {
        AuthCheckFilter.removeExclude( "serverinfo/*" );
    }

    @Override
    public void init() throws ServletException
    {
        AuthCheckFilter.addExclude( "serverinfo/*" );
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        Log.trace( "Processing doGet()" );

        final SessionManager sessionManager = getInstance().getSessionManager();

        final JSONObject servers = new JSONObject();
        servers.put( "incoming", sessionManager.getIncomingServers() );
        servers.put( "outgoing", sessionManager.getOutgoingServers() );

        final JSONObject users = new JSONObject();
        users.put( "connected", CacheFactory.createCache( "Routing User Sessions").size() );
        users.put( "registered", getInstance().getUserManager().getUserCount() );

        final JSONObject info = new JSONObject();
        info.put( "servers", servers );
        info.put( "users", users );

        try ( final Writer writer = response.getWriter() )
        {
            writer.write( info.toString( 2 ) );
            writer.flush();
        }
    }
}