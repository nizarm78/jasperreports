/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2006 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 303 Second Street, Suite 450 North
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.JRHyperlink;
import net.sf.jasperreports.engine.design.JRDesignHyperlink;

import org.xml.sax.Attributes;


/**
 * Factory used to create {@link JRHyperlink hyperlink} for stand-alone JRXML hyperlink specifications.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id$
 */
public class JRHyperlinkFactory extends JRBaseFactory
{
	public static final String ELEMENT_hyperlinkTooltipExpression = "hyperlinkTooltipExpression";
	public static final String ELEMENT_sectionHyperlink = "sectionHyperlink";
	public static final String ELEMENT_itemHyperlink = "itemHyperlink";
	public static final String ELEMENT_anchorNameExpression = "anchorNameExpression";
	public static final String ELEMENT_hyperlinkReferenceExpression = "hyperlinkReferenceExpression";
	public static final String ELEMENT_hyperlinkAnchorExpression = "hyperlinkAnchorExpression";
	public static final String ELEMENT_hyperlinkPageExpression = "hyperlinkPageExpression";
	
	public static final String ATTRIBUTE_hyperlinkType = "hyperlinkType";
	public static final String ATTRIBUTE_hyperlinkTarget = "hyperlinkTarget";

	public Object createObject(Attributes atts) throws Exception
	{
		JRDesignHyperlink link = new JRDesignHyperlink();

		String hyperlinkType = atts.getValue(ATTRIBUTE_hyperlinkType);
		if (hyperlinkType != null)
		{
			link.setLinkType(hyperlinkType);
		}

		Byte hyperlinkTarget = (Byte)JRXmlConstants.getHyperlinkTargetMap().get(atts.getValue(ATTRIBUTE_hyperlinkTarget));
		if (hyperlinkTarget != null)
		{
			link.setHyperlinkTarget(hyperlinkTarget.byteValue());
		}

		return link;
	}

}
