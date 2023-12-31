package org.scrum.domain.services;

import jakarta.annotation.PostConstruct;
import org.scrum.domain.project.Project;
import org.scrum.domain.project.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component("ProjectEntityFactoryBaseCDI")
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProjectEntityFactoryImpl implements IProjectEntityFactory {
	private static Logger logger = Logger.getLogger(ProjectEntityFactoryImpl.class.getName());
	public ProjectEntityFactoryImpl() {
		logger.info(">>> BEAN: ProjectEntityFactoryImpl instantiated!");
	}
	
	// build project with: 1 release, startDate is Now, release publish date:
	// startDate + 1 Month
	@Override
	public Project buildSimpleProject(String projectName) {
		Integer nextID = this.entityRepository.getNextID();
		LocalDateTime startLocalDate = LocalDateTime.now();
		Project newProject = new Project(nextID, projectName, DateUtils4J8API.asDate(startLocalDate));
		// add one release
		List<Release> releasesProject = new ArrayList<>();
		Date dataPublicare = DateUtils4J8API.asDate(startLocalDate.plusMonths(1));
		Release release = new Release(1, "R: " + newProject.getProjectNo() + "." + 1, dataPublicare, newProject);
		releasesProject.add(release);
		newProject.setReleases(releasesProject);
		// make release current
		newProject.setCurrentRelease(release);
		return newProject;
	}

	@Override
	public Project buildProjectWith2R(String projectName, Date startDate, Integer releaseIntervalInMonths) {
		Integer nextID = this.entityRepository.getNextID();
		LocalDateTime startLocalDate = DateUtils4J8API.asLocalDateTime(startDate);
		Project newProject = new Project(nextID, projectName, startDate);

		List<Release> releasesProject = new ArrayList<>();
		Date dataPublicare = DateUtils4J8API.asDate(startLocalDate.plusMonths(1));
		releasesProject.add(new Release(null, "R: " + newProject.getProjectNo() + "." + 1, dataPublicare, newProject));
		dataPublicare = DateUtils4J8API.asDate(startLocalDate.plusMonths(releaseIntervalInMonths));
		releasesProject.add(new Release(null, "R: " + newProject.getProjectNo() + "." + 1, dataPublicare, newProject));
		newProject.setReleases(releasesProject);
		
		newProject.setCurrentRelease(newProject.getReleases().get(0));
		newProject.getCurrentRelease().addFeature("Feature_sample_" + nextID + "_1");
		newProject.getCurrentRelease().addFeature("Feature_sample_" + nextID + "_2");

		logger.info("NEW PROJECT: " + newProject);
		
		return newProject;
	}

	@Override
	public Project buildProjectWith2R(String projectName, LocalDateTime startDate, Integer releaseIntervalInMonths) {
		Integer nextID = this.entityRepository.getNextID();
		LocalDateTime startLocalDate = startDate;
		Project newProject = new Project(nextID, projectName, DateUtils4J8API.asDate(startLocalDate));

		List<Release> releasesProject = new ArrayList<>();
		Date dataPublicare = DateUtils4J8API.asDate(startLocalDate.plusMonths(1));
		releasesProject.add(new Release(null, "R: " + newProject.getProjectNo() + "." + 1, dataPublicare, newProject));
		dataPublicare = DateUtils4J8API.asDate(startLocalDate.plusMonths(releaseIntervalInMonths));
		releasesProject.add(new Release(null, "R: " + newProject.getProjectNo() + "." + 1, dataPublicare, newProject));
		newProject.setReleases(releasesProject);

		return newProject;
	}

	@Override
	public Project buildProjectWithXR(String projectName, List<Date> releaseStartDates) {
		Integer nextID = this.entityRepository.getNextID();
		LocalDateTime startLocalDate = LocalDateTime.now();
		// ? startLocalDate
		Project newProject = new Project(nextID, projectName, DateUtils4J8API.asDate(startLocalDate));
		
		List<Release> releasesProject = new ArrayList<>();
		for(Date releaseStartDate: releaseStartDates) {
			releasesProject.add(new Release(null, "R: " + newProject.getProjectNo() + "." + 1, releaseStartDate, newProject));
		}
		newProject.setReleases(releasesProject);
		
		return newProject;
	}

	// Dependency
	@Autowired
	private IProjectEntityRepository entityRepository;

	@Override
	public void setProjectEntityRepository(IProjectEntityRepository repository) {
		this.entityRepository = repository;
	}
	
	public IProjectEntityRepository getProjectEntityRepository() {
		return entityRepository;
	}

	//
	public ProjectEntityFactoryImpl(IProjectEntityRepository entityRepository) {
		super();
		this.entityRepository = entityRepository;
	}

	@PostConstruct
	private void initDomainServiceEntities() {
		logger.info(">> PostConstruct :: initDomainServiceEntities");
		for(int i=1; i<=3; i++) {
			entityRepository.add(
					buildProjectWith2R("Project_" + i, new Date(), 1)
			);
		}
		logger.info(">> EntityRepository project.count :: " + entityRepository.size());
	}
}

// build Project entity from DTO and update with DTO
/*
@Override
public Project toEntity(Project projectDTO) {
	Project projectEntity = this.entityRepository.get(projectDTO);
	projectEntity.setName(projectDTO.getName());
	projectEntity.setStartDate(projectDTO.getStartDate());
	return projectEntity;
}
*/
