MODULE = "SimpleUmount"
DESCRIPTION = "Unmounter for mass storage devices"
MAINTAINTER = "ambrosa"

inherit gitpkgv
PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "r0"

require openplugins-setuptools3.inc
SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-SimpleUmount.git;protocol=https;branch=python3"

require assume-gplv2.inc
