DESCRIPTION = "lan9500 test application"
LICENSE = "MIT"
PR = "r0"

inherit cmake

LIC_FILES_CHKSUM = "file://version.h;md5=e35eb0251e8981bd7f2c5df7a3749fc5"

SRC_URI = "file://cmd9500.c \
           file://ioctl_9500.h \
	   file://version.h \
           file://CMakeLists.txt \
"

S = "${WORKDIR}"

do_compile () {
	cd ${S}
	cmake .
	make
}

do_install() {
	install -d ${D}${ROOT_HOME}
	install -m 0755 ${S}/lan9500-app ${D}${ROOT_HOME}/lan9500-app
}

FILES_${PN} += "${ROOT_HOME}/*"
