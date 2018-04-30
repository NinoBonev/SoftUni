<?php

/* project/create.html.twig */
class __TwigTemplate_5b28dc0b3980fc0b0375522a4945ec6c68466c5df47c7b5d35b5c50bcf7c5429 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", "project/create.html.twig", 1);
        $this->blocks = array(
            'main' => array($this, 'block_main'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_03472c8b5f9a5f5d4e8d8a6e66e770f563f49cb04fc7cf9ff0f0a43215b0b000 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_03472c8b5f9a5f5d4e8d8a6e66e770f563f49cb04fc7cf9ff0f0a43215b0b000->enter($__internal_03472c8b5f9a5f5d4e8d8a6e66e770f563f49cb04fc7cf9ff0f0a43215b0b000_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "project/create.html.twig"));

        $__internal_cfbb255a1575189d50bf119ee0ad2af21ce88417f35a3b6af00afe8f8ac75f4d = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_cfbb255a1575189d50bf119ee0ad2af21ce88417f35a3b6af00afe8f8ac75f4d->enter($__internal_cfbb255a1575189d50bf119ee0ad2af21ce88417f35a3b6af00afe8f8ac75f4d_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "project/create.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_03472c8b5f9a5f5d4e8d8a6e66e770f563f49cb04fc7cf9ff0f0a43215b0b000->leave($__internal_03472c8b5f9a5f5d4e8d8a6e66e770f563f49cb04fc7cf9ff0f0a43215b0b000_prof);

        
        $__internal_cfbb255a1575189d50bf119ee0ad2af21ce88417f35a3b6af00afe8f8ac75f4d->leave($__internal_cfbb255a1575189d50bf119ee0ad2af21ce88417f35a3b6af00afe8f8ac75f4d_prof);

    }

    // line 3
    public function block_main($context, array $blocks = array())
    {
        $__internal_ecef83816c0f28aa0ffcf32a03a5eed7213c0c02ced77a35111f0232199090f6 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_ecef83816c0f28aa0ffcf32a03a5eed7213c0c02ced77a35111f0232199090f6->enter($__internal_ecef83816c0f28aa0ffcf32a03a5eed7213c0c02ced77a35111f0232199090f6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_3e90064a2d1d40bbce20ca6b30737fca3db3ee5df592187b0f00a5abea2a82e0 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_3e90064a2d1d40bbce20ca6b30737fca3db3ee5df592187b0f00a5abea2a82e0->enter($__internal_3e90064a2d1d40bbce20ca6b30737fca3db3ee5df592187b0f00a5abea2a82e0_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        // line 4
        echo "<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Create Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" />
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"></textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" />
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Create Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        ";
        // line 26
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Form\TwigRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "_token", array()), 'row');
        echo "
    </form>
</div>
";
        
        $__internal_3e90064a2d1d40bbce20ca6b30737fca3db3ee5df592187b0f00a5abea2a82e0->leave($__internal_3e90064a2d1d40bbce20ca6b30737fca3db3ee5df592187b0f00a5abea2a82e0_prof);

        
        $__internal_ecef83816c0f28aa0ffcf32a03a5eed7213c0c02ced77a35111f0232199090f6->leave($__internal_ecef83816c0f28aa0ffcf32a03a5eed7213c0c02ced77a35111f0232199090f6_prof);

    }

    public function getTemplateName()
    {
        return "project/create.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  73 => 26,  49 => 4,  40 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends \"base.html.twig\" %}

{% block main %}
<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Create Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" />
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"></textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" />
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Create Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        {{ form_row(form._token) }}
    </form>
</div>
{% endblock %}", "project/create.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\app\\Resources\\views\\project\\create.html.twig");
    }
}
