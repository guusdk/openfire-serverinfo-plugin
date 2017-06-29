The ServerInfo Plugin is a plugin for the [Openfire XMPP server](https://www.igniterealtime.org/openfire), which exposes basis server information via HTTP as a JSON object. It is modeled after [Thomas Leister's 'mod_serverinfo' for Prosody](https://github.com/ThomasLeister/mod_serverinfo).

Building
--------

This project is using the Maven-based Openfire build process, as introduced in Openfire 4.2.0. To build this plugin locally, ensure that the following are available on your local host:

* A Java Development Kit, version 7 or (preferably) 8
* Apache Maven 3

To build this project, invoke on a command shell:

    $ mvn clean package

Upon completion, the openfire plugin will be available in `target/serverinfo.jar`

Installation
------------
Download the plugin archive file, `serverinfo.jar` from the [releases](https://github.com/guusdk/openfire-serverinfo-plugin/release download page), or build your own copy, as described above.

Copy `serverinfo.jar` into the plugins directory of your Openfire server, or use the Openfire Admin Console to upload the plugin. The plugin will then be automatically deployed.

To upgrade to a new version, copy the new `serverinfo.jar` file over the existing file.

Using the Plugin
----------------
When deployed, the json information will be served on the same ports as are the Admin Console, typically 9090 and 9091. The path will be `/plugins/serverinfo/`

