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

import org.jivesoftware.openfire.container.Plugin;
import org.jivesoftware.openfire.container.PluginManager;

import java.io.File;

/**
 * An Openfire plugin for the ServerInfo plugin.
 *
 * Note that this file is just a placeholder for the Plugin interface, which is mandatory. All magic happens in
 * {@link ServerInfoServlet}.
 *
 * @author Guus der Kinderen, guus.der.kinderen@gmail.com
 */
public class ServerInfoPlugin implements Plugin
{
    @Override
    public void initializePlugin( PluginManager manager, File pluginDirectory )
    {
    }

    @Override
    public void destroyPlugin()
    {
    }
}
