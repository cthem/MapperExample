# MapStruct

## SetUp

* Add below Maven dependency to pom.xml:
```
<dependency>
	<groupId>org.mapstruct</groupId>
	<artifactId>mapstruct-jdk8</artifactId>
	<version>1.1.0.Final</version> 
</dependency>
```
* Add below plugin to pom.xml:
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.5.1</version>
    <configuration>
        <source>1.8</source>
    <target>1.8</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.1.0.Final</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

## Explanation

In this project, I have created 3 Entities: Student, School and Course. Student and School have OneToOne relationship, while Student and Course have OneToMany relationship (in the real world the correct relationship is ManyToMany, however I have used OneToMany to simplify this case). In addition, I have created 3 DTO: StudentDto, SchoolDto and CourseDto which contain all entity fields. For the reference fields I have used different names (e.g. Student entity contains a School field named school, while StudentDto class contains a SchoolDto field named schoolDto).

The next step is to create a mapper interface using the annotation @Mapper. In this interface we declare all functions to be used so as to transform entities to dto and dto to entities.

```
@Mapper(componentModel = "sdi")
public interface EntityDtoMapper {

//	@Mappings({
//		@Mapping(target="schoolDto", source="school"),
//		@Mapping(target="coursesDto", source="courses")
//	})
	StudentDto convertStudentToStudentDto(Student student);
//	@Mappings({
//		@Mapping(target="school", source="schoolDto"),
//		@Mapping(target="courses", source="coursesDto")
//	})
	Student convertStudentDtoToStudent(StudentDto studentDto);
	
	@Mapping(target="studentDto",source="student")
	SchoolDto convertSchoolToSchoolDto(School school);
	@Mapping(target="student",source="studentDto")
	School convertSchoolDtoToSchool(SchoolDto schoolDto);
	
	@Mapping(target="studentDto",source="student")
	CourseDto convertCourseToCourseDto(Course course);
	@Mapping(target="student",source="studentDto")
	Course convertCourseDtoToCourse(CourseDto courseDto);
}

```

As you probably have noticed in the above code, I have used the @Mapping annotation when variable names in an entity and dto have different names. After having created this interface, I do not have to implemented. I simply use Maven clean install and the implementation is automatically created in the target folder.

Please note that, since entities and dto have references to each other (e.g. student has reference to school and school to student), we cannot add @Mapping annotation to both functions. If we do so, a StackOverflow exception will be thrown. Since I have not added @Mapping annotation to Student functions, the produced implementation will not set the fields of coursesDto and schoolDto. On the contrary, the field studentDto in SchoolDto and CourseDto will be set normally.