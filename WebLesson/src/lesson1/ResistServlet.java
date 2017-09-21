package lesson1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ResistServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");


		String english = req.getParameter("english");
		String japanese = req.getParameter("japanese");
		String result = req.getParameter("result");
		String record = req.getParameter("record");


		req.setAttribute("english",english);
		req.setAttribute("japanese",japanese);

		WordDAO dao = new WordDAO();
		List<Word>lists = new ArrayList<>();
		lists.add(new Word(english, japanese));
		int count = dao.registWord(lists);
		result = String.valueOf(count);
		req.setAttribute("result",result);


		record = dao.getWords();
		req.setAttribute("record",record);

		req.getRequestDispatcher("result.jsp").forward(req,res);
	}


}




