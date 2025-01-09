package com.smhrd.controller;

import com.google.gson.Gson;
import com.smhrd.model.LocationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/map")
public class MapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 파라미터 postIdx 확인
            String postIdxParam = request.getParameter("postIdx");
            if (postIdxParam == null || postIdxParam.isEmpty()) {
                throw new IllegalArgumentException("postIdx parameter is missing");
            }

            int postIdx = Integer.parseInt(postIdxParam);
            LocationDAO locationDAO = new LocationDAO();
            Map<String, Object> location = locationDAO.getLocation(postIdx);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            Gson gson = new Gson();
            if (location != null) {
                response.getWriter().write(gson.toJson(location));
            } else {
                // 기본 좌표 반환
                response.getWriter().write(gson.toJson(Map.of("latitude", 37.5665, "longitude", 126.9780)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid request or server error\"}");
        }
    }
}
