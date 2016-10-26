#!/bin/bash
# Copyright (c) 2000-2016 Synology Inc. All rights reserved.

source /pkgscripts/include/pkg_util.sh

UISTRING_PATH="/source/syno-library/package/ui/texts"
description_sec="app"
description_key="description"
displayname_sec="app"
displayname_key="title"

package="syno-library"
version="0.0.0004"
maintainer="Synology Community"
arch="bromolow"

dsmuidir="ui"
dsmappname="SYNOCOMMUNITY.sl.AppInstance"

thirdparty="yes"

install_dep_services="apache-web pgsql Tomcat7"
install_dep_packages="Tomcat7"
start_dep_services="apache-web pgsql"

[ "$(caller)" != "0 NULL" ] && return 0
pkg_dump_info
