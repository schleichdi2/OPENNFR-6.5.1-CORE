FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

RRECOMMENDS:alsa-state:append = " libasound-module-ctl-oss libasound-module-pcm-oss"

PR:append = ".8"
PACKAGE_ARCH := "${MACHINE_ARCH}"

EXTRA_ALSA ?= "empty"
EXTRA_ALSA:vuduo4k = "vuplus"
EXTRA_ALSA:vuduo4kse = "vuplus"
EXTRA_ALSA:vusolo4k = "vuplus"
EXTRA_ALSA:vuultimo4k = "vuplus"
EXTRA_ALSA:vuuno4k = "vuplus"
EXTRA_ALSA:vuuno4kse = "vuplus"
EXTRA_ALSA:vuzero4k = "vuplus"
EXTRA_ALSA:vuduo2 = "vuplus"
EXTRA_ALSA:vusolo2 = "vuplus"
EXTRA_ALSA:vusolose = "vuplus"
EXTRA_ALSA:AMLS905 = "amls905"
EXTRA_ALSA:AML905D = "aml905d"
EXTRA_ALSA:AML8726 = "aml8726"
EXTRA_ALSA:viper4k = "mv200"
EXTRA_ALSA:beyonwizv2 = "mv200"
EXTRA_ALSA:gbmv200 = "mv200"
EXTRA_ALSA:sf8008 = "mv200"
EXTRA_ALSA:sf8008m = "mv200"
EXTRA_ALSA:ustym4kpro = "mv200"

require alsa-state-${EXTRA_ALSA}.inc