<?php

/* @WebProfiler/Collector/ajax.html.twig */
class __TwigTemplate_1ba2844ce327644c79ce021cb22291f7c7f4345900a886756bff7f8093a09dc7 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/ajax.html.twig", 1);
        $this->blocks = array(
            'toolbar' => array($this, 'block_toolbar'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@WebProfiler/Profiler/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_09081cab030ab7ad815acc22a42ee92b1cec3e8ce3a0ed9ebf4839f8a79a02ad = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_09081cab030ab7ad815acc22a42ee92b1cec3e8ce3a0ed9ebf4839f8a79a02ad->enter($__internal_09081cab030ab7ad815acc22a42ee92b1cec3e8ce3a0ed9ebf4839f8a79a02ad_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/ajax.html.twig"));

        $__internal_070e9696c6ad0e8c93f220716f56a38782fe936f54965a33124bdac7f4d0e753 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_070e9696c6ad0e8c93f220716f56a38782fe936f54965a33124bdac7f4d0e753->enter($__internal_070e9696c6ad0e8c93f220716f56a38782fe936f54965a33124bdac7f4d0e753_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/ajax.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_09081cab030ab7ad815acc22a42ee92b1cec3e8ce3a0ed9ebf4839f8a79a02ad->leave($__internal_09081cab030ab7ad815acc22a42ee92b1cec3e8ce3a0ed9ebf4839f8a79a02ad_prof);

        
        $__internal_070e9696c6ad0e8c93f220716f56a38782fe936f54965a33124bdac7f4d0e753->leave($__internal_070e9696c6ad0e8c93f220716f56a38782fe936f54965a33124bdac7f4d0e753_prof);

    }

    // line 3
    public function block_toolbar($context, array $blocks = array())
    {
        $__internal_051f49dd2d6640c94a71fbf62e3852ddeaf277ede3e742356fef48b36b8d4f2d = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_051f49dd2d6640c94a71fbf62e3852ddeaf277ede3e742356fef48b36b8d4f2d->enter($__internal_051f49dd2d6640c94a71fbf62e3852ddeaf277ede3e742356fef48b36b8d4f2d_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        $__internal_b81bc52bb4521241f4f5939a138c22bb0214d8d362eb77782769d172fb1c5171 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_b81bc52bb4521241f4f5939a138c22bb0214d8d362eb77782769d172fb1c5171->enter($__internal_b81bc52bb4521241f4f5939a138c22bb0214d8d362eb77782769d172fb1c5171_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        // line 4
        echo "    ";
        ob_start();
        // line 5
        echo "        ";
        echo twig_include($this->env, $context, "@WebProfiler/Icon/ajax.svg");
        echo "
        <span class=\"sf-toolbar-value sf-toolbar-ajax-request-counter\">0</span>
    ";
        $context["icon"] = ('' === $tmp = ob_get_clean()) ? '' : new Twig_Markup($tmp, $this->env->getCharset());
        // line 8
        echo "
    ";
        // line 9
        $context["text"] = ('' === $tmp = "        <div class=\"sf-toolbar-info-piece\">
            <b class=\"sf-toolbar-ajax-info\"></b>
        </div>
        <div class=\"sf-toolbar-info-piece\">
            <table class=\"sf-toolbar-ajax-requests\">
                <thead>
                    <tr>
                        <th>Method</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>URL</th>
                        <th>Time</th>
                        <th>Profile</th>
                    </tr>
                </thead>
                <tbody class=\"sf-toolbar-ajax-request-list\"></tbody>
            </table>
        </div>
    ") ? '' : new Twig_Markup($tmp, $this->env->getCharset());
        // line 29
        echo "
    ";
        // line 30
        echo twig_include($this->env, $context, "@WebProfiler/Profiler/toolbar_item.html.twig", array("link" => false));
        echo "
";
        
        $__internal_b81bc52bb4521241f4f5939a138c22bb0214d8d362eb77782769d172fb1c5171->leave($__internal_b81bc52bb4521241f4f5939a138c22bb0214d8d362eb77782769d172fb1c5171_prof);

        
        $__internal_051f49dd2d6640c94a71fbf62e3852ddeaf277ede3e742356fef48b36b8d4f2d->leave($__internal_051f49dd2d6640c94a71fbf62e3852ddeaf277ede3e742356fef48b36b8d4f2d_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/ajax.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  85 => 30,  82 => 29,  62 => 9,  59 => 8,  52 => 5,  49 => 4,  40 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends '@WebProfiler/Profiler/layout.html.twig' %}

{% block toolbar %}
    {% set icon %}
        {{ include('@WebProfiler/Icon/ajax.svg') }}
        <span class=\"sf-toolbar-value sf-toolbar-ajax-request-counter\">0</span>
    {% endset %}

    {% set text %}
        <div class=\"sf-toolbar-info-piece\">
            <b class=\"sf-toolbar-ajax-info\"></b>
        </div>
        <div class=\"sf-toolbar-info-piece\">
            <table class=\"sf-toolbar-ajax-requests\">
                <thead>
                    <tr>
                        <th>Method</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>URL</th>
                        <th>Time</th>
                        <th>Profile</th>
                    </tr>
                </thead>
                <tbody class=\"sf-toolbar-ajax-request-list\"></tbody>
            </table>
        </div>
    {% endset %}

    {{ include('@WebProfiler/Profiler/toolbar_item.html.twig', { link: false }) }}
{% endblock %}
", "@WebProfiler/Collector/ajax.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\WebProfilerBundle\\Resources\\views\\Collector\\ajax.html.twig");
    }
}
