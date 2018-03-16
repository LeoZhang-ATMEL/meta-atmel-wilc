DESCRIPTION = "Microchip libplanes library for sama5 lcd controller"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;endline=20;md5=b884a464579c410fd1dace93db8e97b3"

PACKAGES = "${PN}-dbg ${PN}"

PR = "r1"

DEPENDS = "libdrm cairo cjson lua"

RDEPENDS_${PN} = "python"

SRC_URI = "git://github.com/linux4sam/libplanes.git;branch=master;protocol=http"

SRCREV = "08f7dc12436572c1c36a457e36e5d6ea453f66ac"

S = "${WORKDIR}/git"

inherit pkgconfig autotools

EXTRA_OECONF += "--enable-shared --disable-static"

do_configure_prepend() {
	( cd ${S};
	${S}/autogen.sh; cd -)
}

INSANE_SKIP_${PN} = "dev-so"

FILES_${PN}-dbg += "${bindir}/.debug"

FILES_${PN} += " \
  /opt/planes/planes-loop.sh \
  /opt/ApplicationL* \
  ${libdir}/* \
  ${includedir}/* \
  ${bindir}/* \
  /usr/share/planes/* \
"

#need to delete _planes.a to avoid QA package errors
do_install_append() {
    install -Dm 0644 ${S}/scripts/planes.png  ${D}/opt/ApplicationLauncher/applications/resources/planes.png
    install -Dm 0644 ${S}/scripts/09-planes.xml  ${D}/opt/ApplicationLauncher/applications/xml/09-planes.xml
    install -Dm 0755 ${S}/scripts/planes-loop.sh ${D}/opt/planes/planes-loop.sh
    install -Dm 0755 ${S}/python/examples/splash.py ${D}/usr/share/planes/splash.py
    rm -f ${D}/usr/lib/python2.7/site-packages/planes/_planes.a
    rm -f ${D}/usr/lib/libplanes.a
}
