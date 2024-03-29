
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.ComplaintRepository;
import domain.Complaint;

@Component
@Transactional
public class StringToComplaintConverter implements Converter<String, Complaint> {

	@Autowired
	private ComplaintRepository	cr;


	@Override
	public Complaint convert(final String text) {
		Complaint result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = this.cr.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;

	}

}
