MODULE = "StreamInterface"
DESCRIPTION = "Stream webinterface on port 40080"

RDEPENDS:${PN} = "${PYTHON_PN}-twisted-web"

require openplugins-replace-pli.inc

require openplugins-setuptools3.inc

require assume-gplv2.inc
