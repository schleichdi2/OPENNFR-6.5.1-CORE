require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

SRC_URI_append = "file://hiplayer-20.patch"


DEPENDS += "beyonwiz-libs-${MACHINE}"
PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES_${PN} += "kodi"

RDEPENDS_${PN} += "beyonwiz-libs-${MACHINE}"
RDEPENDS_${PN} += "beyonwiz-opengl-${MACHINE}"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=clap-cortexa15 \
    -DWITH_FFMPEG=stb \
"
