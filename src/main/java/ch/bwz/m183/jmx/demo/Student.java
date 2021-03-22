package ch.bwz.m183.jmx.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements StudentMBean {
	private static final Logger LOG = LoggerFactory.getLogger(Student.class);

	private String studentName;

	public void studySubject(String subject) {
		LOG.debug(this.studentName + " studying " + subject);
	}

	@Override
	public String getStudentName() {
		LOG.debug("Return studentName " + this.studentName);
		return studentName;
	}

	@Override
	public void setStudentName(String studentName) {
		LOG.debug("Set studentName to value " + studentName);
		this.studentName = studentName;
	}
}
