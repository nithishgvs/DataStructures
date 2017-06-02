package org.nithish.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoursesSchedule {

	public static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {
		List<String> courseScheduleList = new ArrayList<>();
		Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);
		Map<String, Integer> courseIdMap = new HashMap<>();
		Map<Integer, String> idCourseMap = new HashMap<>();
		for (int i = 0; i < courseList.size(); i++) {
			courseIdMap.put(courseList.get(i), i);
			idCourseMap.put(i, courseList.get(i));

		}
		for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
			for (String course : prereq.getValue()) {
				courseGraph.addEdge(courseIdMap.get(prereq.getKey()), courseIdMap.get(course));
			}
		}
		List<Integer> courseIdList = TopologicalSort.sort(courseGraph);
		for (int courseId : courseIdList) {
			courseScheduleList.add(idCourseMap.get(courseId));
		}

		return courseScheduleList;
	}

}
