
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.PhaseRepository;
import domain.Phase;

@Component
@Transactional
public class StringToPhaseConverter implements Converter<String, Phase> {

	@Autowired
	private PhaseRepository	wr;


	@Override
	public Phase convert(final String text) {
		Phase result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = this.wr.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return result;
	}

}
