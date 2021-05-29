require python-pyqt5.inc

inherit python3native python3-dir

DEPENDS += "sip sip-native python3"

RDEPENDS_${PN} += "python3-core python3-sip"

