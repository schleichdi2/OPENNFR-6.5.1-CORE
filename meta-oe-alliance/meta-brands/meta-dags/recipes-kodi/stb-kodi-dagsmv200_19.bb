require recipes-mediacenter/kodi/stb-kodi_${PV}.bb

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCDATE = "20210318"

SRC_URI:append = " http://source.mynonpublic.com/kodi/hiplayer_kodi_19_${SRCDATE}.tar.gz \
                file://hiplayer-19.patch \
"

SRC_URI[md5sum] = "354009435a91f1bdd81b64e6ccb446e3"
SRC_URI[sha256sum] = "25055d538fc9633cd050be3242bcdf45f5ceec9ee9b56429a231612f5160c6c7"

DEPENDS += "dags-libs-${SOC_FAMILY}"
PROVIDES += "virtual/kodi"
RPROVIDES:${PN} += "virtual/kodi"
PROVIDES += "kodi"
RPROVIDES:${PN} += "kodi"

RDEPENDS:${PN} += "dags-libs-${SOC_FAMILY}"
RDEPENDS:${PN} += "dags-opengl-${SOC_FAMILY}"

do_configure:append() {
        install -d ${D}${libdir}
        install -d ${WORKDIR}/git/xbmc/platform/linux/hisi/
        install -d ${WORKDIR}/git/xbmc/cores/hiplayer/
        install -m 0755 ${WORKDIR}/hiadp.a      ${WORKDIR}/git/xbmc/platform/linux/hisi/
        install -m 0755 ${WORKDIR}/hiplayer.a   ${WORKDIR}/git/xbmc/cores/hiplayer/
}

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=clap-cortexa15 \
    -DWITH_FFMPEG=stb \
"
