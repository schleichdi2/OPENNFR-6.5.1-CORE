MODULE = "ChangeRootPassword"
DESCRIPTION = "Set/Change your box password"

SRCREV = ""

inherit gitpkgv
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r1"

require openplugins-setuptools3.inc

require assume-gplv2.inc
