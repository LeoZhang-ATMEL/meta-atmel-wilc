DESCRIPTION = "lan9500 test application"
LICENSE = "MIT"
PR = "r0"

LIC_FILES_CHKSUM = "file://version.h;md5=e35eb0251e8981bd7f2c5df7a3749fc5"

SRC_URI = "file://cmd9500.c \
           file://ioctl_9500.h \
	   file://version.h \
           file://Makefile-app \
"

S = "${WORKDIR}"

do_compile () {
	make -f Makefile-app
}

do_install() {
	install -d /home/root/
}
