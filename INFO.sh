#!/bin/bash
# Copyright (c) 2000-2016 Synology Inc. All rights reserved.

source /pkgscripts/include/pkg_util.sh

UISTRING_PATH="/source/syno-library/package/ui/texts"
# Avec la version 6.1, la description et le nom sont obligatoires et ne peuvent plus être construit à partir des fichiers de traduction.
displayname=syno-library
description=syno-library

package="syno-library"
version="0.0.0005"
maintainer="Synology Community"
arch="$(pkg_get_platform)"

dsmuidir="ui"
dsmappname="SYNOCOMMUNITY.sl.AppInstance"

thirdparty="yes"

install_dep_services="apache-web pgsql Tomcat7"
install_dep_packages="Tomcat7"
start_dep_services="apache-web pgsql"

[ "$(caller)" != "0 NULL" ] && return 0
pkg_dump_info
